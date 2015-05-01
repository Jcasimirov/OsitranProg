package com.ositran.util;

import com.ositran.model.TFeriado;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean(eager=true)
@ApplicationScoped()
public class FechasUtil {
        private int[] diasNoHabiles;

	public FechasUtil() throws Exception {
		Properties propiedadesSistema=new Properties(System.getProperties());
		FileInputStream archivoPropiedades=null;
		try {
		    archivoPropiedades=(FileInputStream)FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/WEB-INF/properties/dias_no_habiles.properties");
                    propiedadesSistema.load(archivoPropiedades);
		} finally {
			if (archivoPropiedades!=null) {
				archivoPropiedades.close();
			}
		}
		System.setProperties(propiedadesSistema);
                diasNoHabiles=retornaDiasNoHabiles();
                Arrays.sort(diasNoHabiles);
		System.out.println("\""+System.getProperty("user.name")+"\"");
		System.out.println("\""+System.getProperty("os.arch")+"\"");
		System.out.println("\""+System.getProperty("java.home")+"\"");
		System.out.println("\""+System.getProperty("ositran.diasNoHabiles")+"\"");
	}
	
	public Date adicionaDias(Date fecha, int dias, int esDiasHabiles) throws Exception {
		if (fecha==null) {
			throw new IllegalArgumentException("El parámetro \"fecha\" no puede ser null.");
		}
		if (dias<0) {
			throw new IllegalArgumentException("El parámetro \"dias\" no admite valores negativos.");
		}
		if (esDiasHabiles!=0 && esDiasHabiles!=1) {
			throw new IllegalArgumentException("El parámetro \"esDiasHabiles\" no tiene un valor válido.");
		}
		
		if (dias==0) {
			return fecha;
		} else {
			Calendar fechaGregoriana=Calendar.getInstance(),fechaGregorianaIncial;
			
			fechaGregoriana.setTime(fecha);			
			switch (esDiasHabiles) {
				case 0:
					fechaGregoriana.add(Calendar.DATE, dias);
				break;
				case 1:
					boolean esDiaActualNoHabil=false;
					boolean calculandoFeriados=false;
					int numeroDiasHabiles=7-diasNoHabiles.length;
					int numeroPeriodos;
					int numeroDiasRestantes;
					
					while (Arrays.binarySearch(diasNoHabiles,fechaGregoriana.get(Calendar.DAY_OF_WEEK))>=0) {
						fechaGregoriana.add(Calendar.DATE,1);
						esDiaActualNoHabil=true;
					}
					
					if (esDiaActualNoHabil) {
						dias--;
					}
					
					while (dias!=0) {
						numeroPeriodos=dias/numeroDiasHabiles;
						numeroDiasRestantes=dias%numeroDiasHabiles;
						
						fechaGregorianaIncial=(GregorianCalendar)fechaGregoriana.clone();
						fechaGregoriana.add(Calendar.DATE,numeroPeriodos*7);
						while (numeroDiasRestantes!=0) {
							fechaGregoriana.add(Calendar.DATE,1);
							if (Arrays.binarySearch(diasNoHabiles,fechaGregoriana.get(Calendar.DAY_OF_WEEK))<0) {
								numeroDiasRestantes--;
							}
						}
						if (calculandoFeriados) {
							fechaGregorianaIncial.add(Calendar.DATE, 1);
						} else {
							calculandoFeriados=true;
						}
						dias=retornaNumeroDeFeriados(fechaGregorianaIncial,fechaGregoriana);
					}
				break;
			}
			return fechaGregoriana.getTime();
		}
	}

	public int retornaNumeroDeFeriados(Calendar fechaInicial,Calendar fechaFinal) throws Exception {
		if (fechaInicial.after(fechaFinal)) {
			throw new IllegalArgumentException("\"fechaInicial\" no puede representar un tiempo después a el tiempo representado por \"fechaFinal\".");
		}

		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
		Transaction tx=null;
		Query consultaFeriadosVariables=null;
		Query consultaFeriadosFijos1=null;
		List<GregorianCalendar> feriados=new ArrayList<GregorianCalendar>();
		List<TFeriado> feriadosFijosResultado1=null;
		List<TFeriado> feriadosVariablesResultado=null;
		
		try {
			tx=session.beginTransaction();
			if(fechaInicial.get(Calendar.YEAR)!=fechaFinal.get(Calendar.YEAR)) {
				List<TFeriado> feriadosFijosResultado2=null;
				List<TFeriado> feriadosFijosResultado3=null;
				Query consultaFeriadosFijos2=null;
				Query consultaFeriadosFijos3=null;
				int contador=fechaFinal.get(Calendar.YEAR)-fechaInicial.get(Calendar.YEAR)-1;
				
				consultaFeriadosVariables=session.createQuery("FROM TFeriado a"
															+" WHERE a.ferTipo=1 AND ((a.ferAnyo=:anioInicial AND a.ferMes=:mesInicial AND a.ferDia>=:diaInicial)"
															+" OR (a.ferAnyo=:anioInicial AND a.ferMes>:mesInicial)"
															+" OR (a.ferAnyo>:anioInicial AND a.ferAnyo<:anioFinal)"
															+" OR (a.ferAnyo=:anioFinal AND a.ferMes<:mesFinal)"
															+" OR (a.ferAnyo=:anioFinal AND a.ferMes=:mesFinal AND a.ferDia<=:diaFinal))");
				consultaFeriadosVariables.setInteger("anioFinal",fechaFinal.get(Calendar.YEAR));
				consultaFeriadosVariables.setInteger("mesFinal",fechaFinal.get(Calendar.MONTH)+1);
				consultaFeriadosFijos1=session.createQuery("FROM TFeriado a"
														+" WHERE a.ferTipo=0 AND ((a.ferMes=:mesInicial AND a.ferDia>=:diaInicial)"
														+" OR a.ferMes>:mesInicial)");
				consultaFeriadosFijos2=session.createQuery("FROM TFeriado a"
														+" WHERE a.ferTipo=0");
				consultaFeriadosFijos3=session.createQuery("FROM TFeriado a"
														+" WHERE a.ferTipo=0 AND (a.ferMes<:mesFinal"
														+ " OR (a.ferMes=:mesFinal AND a.ferDia<=:diaFinal))");
				consultaFeriadosFijos3.setInteger("diaFinal",fechaFinal.get(Calendar.DATE));
				consultaFeriadosFijos3.setInteger("mesFinal",fechaFinal.get(Calendar.MONTH)+1);
				feriadosFijosResultado2=(List<TFeriado>)consultaFeriadosFijos2.list();
				while (contador>0) {
					for (TFeriado aux : feriadosFijosResultado2) {
						GregorianCalendar feriado=new GregorianCalendar(fechaInicial.get(Calendar.YEAR)+contador, aux.getFerMes()-1, aux.getFerDia());
						if (Arrays.binarySearch(diasNoHabiles,feriado.get(Calendar.DAY_OF_WEEK))<0) {
							feriados.add(feriado);
						}
					}
					contador--;
				}
				feriadosFijosResultado3=(List<TFeriado>)consultaFeriadosFijos3.list();
				for (TFeriado aux : feriadosFijosResultado3) {
					GregorianCalendar feriado=new GregorianCalendar(fechaFinal.get(Calendar.YEAR), aux.getFerMes()-1, aux.getFerDia());
					if (Arrays.binarySearch(diasNoHabiles,feriado.get(Calendar.DAY_OF_WEEK))<0) {
						feriados.add(feriado);
					}
				}
			} else {
				if (fechaInicial.get(Calendar.MONTH)!=fechaFinal.get(Calendar.MONTH)) {
					consultaFeriadosVariables=session.createQuery("FROM TFeriado a"
																+" WHERE a.ferTipo=1 AND a.ferAnyo=:anioInicial AND ((a.ferMes=:mesInicial AND a.ferDia>=:diaInicial)"
																+" OR (a.ferMes>:mesInicial AND a.ferMes<:mesFinal)"
																+" OR (a.ferMes=:mesFinal AND a.ferDia<=:diaFinal))");
					consultaFeriadosVariables.setInteger("mesFinal",fechaFinal.get(Calendar.MONTH)+1);
					consultaFeriadosFijos1=session.createQuery("FROM TFeriado a"
															+" WHERE a.ferTipo=0 AND ((a.ferMes=:mesInicial AND a.ferDia>=:diaInicial)"
															+" OR (a.ferMes>:mesInicial AND a.ferMes<:mesFinal)"
															+" OR (a.ferMes=:mesFinal AND a.ferDia<=:diaFinal))");
					consultaFeriadosFijos1.setInteger("mesFinal",fechaFinal.get(Calendar.MONTH)+1);
				} else {
					consultaFeriadosVariables=session.createQuery("FROM TFeriado a"
																+" WHERE a.ferTipo=1 AND a.ferAnyo=:anioInicial AND a.ferMes=:mesInicial AND a.ferDia>=:diaInicial AND a.ferDia<=:diaFinal");
					consultaFeriadosFijos1=session.createQuery("FROM TFeriado a"
															+" WHERE a.ferTipo=0 AND a.ferMes=:mesInicial AND a.ferDia>=:diaInicial AND a.ferDia<=:diaFinal");
				}
				consultaFeriadosFijos1.setInteger("diaFinal",fechaFinal.get(Calendar.DATE));
			}
			
			consultaFeriadosFijos1.setInteger("diaInicial",fechaInicial.get(Calendar.DATE));
			consultaFeriadosFijos1.setInteger("mesInicial",fechaInicial.get(Calendar.MONTH)+1);
			feriadosFijosResultado1=(List<TFeriado>)consultaFeriadosFijos1.list();
			for (TFeriado aux : feriadosFijosResultado1) {
				GregorianCalendar feriado=new GregorianCalendar(fechaInicial.get(Calendar.YEAR), aux.getFerMes()-1, aux.getFerDia());
				if (Arrays.binarySearch(diasNoHabiles,feriado.get(Calendar.DAY_OF_WEEK))<0) {
					feriados.add(feriado);
				}
			}
			
			consultaFeriadosVariables.setInteger("anioInicial",fechaInicial.get(Calendar.YEAR));
			consultaFeriadosVariables.setInteger("mesInicial",fechaInicial.get(Calendar.MONTH)+1);
			consultaFeriadosVariables.setInteger("diaInicial",fechaInicial.get(Calendar.DATE));
			consultaFeriadosVariables.setInteger("diaFinal",fechaFinal.get(Calendar.DATE));
			feriadosVariablesResultado=(List<TFeriado>)consultaFeriadosVariables.list();
			for (TFeriado aux : feriadosVariablesResultado) {
				GregorianCalendar feriado=new GregorianCalendar(aux.getFerAnyo(), aux.getFerMes()-1, aux.getFerDia());
				if (Arrays.binarySearch(diasNoHabiles,feriado.get(Calendar.DAY_OF_WEEK))<0) {
					feriados.add(feriado);
				}
			}
			tx.commit();
			return feriados.size();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	private int[] retornaDiasNoHabiles() {
		String[] propiedadesDiasNoHabiles=System.getProperty("ositran.diasNoHabiles").split(",");
		int[] diasNoHabiles=new int[propiedadesDiasNoHabiles.length];
		int i=0;

		for (String propiedadDiasNoHabiles : propiedadesDiasNoHabiles) {
			propiedadDiasNoHabiles=propiedadDiasNoHabiles.trim().toLowerCase();
			switch (propiedadDiasNoHabiles) {
				case "lunes":
					diasNoHabiles[i]=Calendar.MONDAY;
				break;
				case "martes":
					diasNoHabiles[i]=Calendar.TUESDAY;
				break;
				case "miercoles":
					diasNoHabiles[i]=Calendar.WEDNESDAY;
				break;
				case "jueves":
					diasNoHabiles[i]=Calendar.THURSDAY;
				break;
				case "viernes":
					diasNoHabiles[i]=Calendar.FRIDAY;
				break;
				case "sabado":
					diasNoHabiles[i]=Calendar.SATURDAY;
				break;
				case "domingo":
					diasNoHabiles[i]=Calendar.SUNDAY;
				break;
			}
			i++;
		}
		
		return diasNoHabiles;
	}
	
	public String devuelveFecha(Calendar fecha) {
		return fecha.get(Calendar.YEAR)+" / "+devuelveNombreMes(fecha)+" / "+fecha.get(Calendar.DAY_OF_MONTH)+" / "+devuelveNombreDiaSemana(fecha)+" / "+fecha.get(Calendar.HOUR_OF_DAY)+" / "+fecha.get(Calendar.MINUTE)+" / "+fecha.get(Calendar.SECOND);
	}

	public String devuelveFecha(Date fecha) {
		Calendar fechaGregoriana=Calendar.getInstance();
		fechaGregoriana.setTime(fecha);
		return fechaGregoriana.get(Calendar.YEAR)+" / "+devuelveNombreMes(fechaGregoriana)+" / "+fechaGregoriana.get(Calendar.DAY_OF_MONTH)+" / "+devuelveNombreDiaSemana(fechaGregoriana)+" / "+fechaGregoriana.get(Calendar.HOUR_OF_DAY)+" / "+fechaGregoriana.get(Calendar.MINUTE)+" / "+fechaGregoriana.get(Calendar.SECOND);
	}

	public String devuelveNombreMes(Calendar fecha) {
		String mes=null;
		
		switch (fecha.get(Calendar.MONTH)) {
			case Calendar.JANUARY:
				mes="Enero";
			break;
			case Calendar.FEBRUARY:
				mes="Febrero";
			break;
			case Calendar.MARCH:
				mes="Marzo";
			break;
			case Calendar.APRIL:
				mes="Abril";
			break;
			case Calendar.MAY:
				mes="Mayo";
			break;
			case Calendar.JUNE:
				mes="Junio";
			break;
			case Calendar.JULY:
				mes="Julio";
			break;
			case Calendar.AUGUST:
				mes="Agosto";
			break;
			case Calendar.SEPTEMBER:
				mes="Setiembre";
			break;
			case Calendar.OCTOBER:
				mes="Octubre";
			break;
			case Calendar.NOVEMBER:
				mes="Noviembre";
			break;
			case Calendar.DECEMBER:
				mes="Diciembre";
			break;
		}
		return mes;
	}

	public String devuelveNombreDiaSemana(Calendar fecha) {
		return devuelveNombreDiaSemana(fecha.get(Calendar.DAY_OF_WEEK));
	}

	public String devuelveNombreDiaSemana(int diaSemana) {
		String nombreDiaSemana=null;
		
		switch (diaSemana) {
			case Calendar.MONDAY:
				nombreDiaSemana="Lunes";
			break;
			case Calendar.TUESDAY:
				nombreDiaSemana="Martes";
			break;
			case Calendar.WEDNESDAY:
				nombreDiaSemana="Miércoles";
			break;
			case Calendar.THURSDAY:
				nombreDiaSemana="Jueves";
			break;
			case Calendar.FRIDAY:
				nombreDiaSemana="Viernes";
			break;
			case Calendar.SATURDAY:
				nombreDiaSemana="Sábado";
			break;
			case Calendar.SUNDAY:
				nombreDiaSemana="Domingo";
			break;
		}
		return nombreDiaSemana;
	}

	/*public static Date adicionaDias1(Date fecha, int dias, int esDiasHabiles) throws Exception {
		if (fecha==null) {
			throw new IllegalArgumentException("El parámetro \"fecha\" no puede ser null.");
		}
		if (dias<0) {
			throw new IllegalArgumentException("El parámetro \"dias\" no admite valores negativos.");
		}
		if (esDiasHabiles!=0 && esDiasHabiles!=1) {
			throw new IllegalArgumentException("El parámetro \"esDiasHabiles\" no tiene un valor válido.");
		}
		
		Calendar fechaGregoriana=Calendar.getInstance(),fechaGregorianaIncial;
		
		fechaGregoriana.setTime(fecha);
		System.out.println(devuelveFecha(fechaGregoriana));
		
		if (dias>0) {
			int[] diasNoHabiles=retornaDiasNoHabiles();
			
			switch (esDiasHabiles) {
				case 0:
					fechaGregoriana.add(Calendar.DATE, dias);
				break;
				case 1:
					boolean esDiaActualNoHabil=false;
					int numeroDiasHabiles=7-diasNoHabiles.length;
					int numeroPeriodos;
					int numeroDiasRestantes;
					
					Arrays.sort(diasNoHabiles);
					while (Arrays.binarySearch(diasNoHabiles,fechaGregoriana.get(Calendar.DAY_OF_WEEK))>=0) {
						fechaGregoriana.add(Calendar.DATE,1);
						esDiaActualNoHabil=true;
					}
					
					if (esDiaActualNoHabil) {
						dias--;
					}
					
					numeroPeriodos=dias/numeroDiasHabiles;
					numeroDiasRestantes=dias%numeroDiasHabiles;
					
					fechaGregorianaIncial=(GregorianCalendar)fechaGregoriana.clone();
					fechaGregoriana.add(Calendar.DATE,numeroPeriodos*7);
					while (numeroDiasRestantes!=0) {
						fechaGregoriana.add(Calendar.DATE,1);
						if (Arrays.binarySearch(diasNoHabiles,fechaGregoriana.get(Calendar.DAY_OF_WEEK))<0) {
							numeroDiasRestantes--;
						}
					}
					
					int numeroDeFeriados=retornaNumeroDeFeriados(fechaGregorianaIncial,fechaGregoriana);
					System.out.println("El numero de feriados entre \""+devuelveFecha(fechaGregorianaIncial)+"\" y \""+devuelveFecha(fechaGregoriana)+"\" es: "+numeroDeFeriados);
					while (numeroDeFeriados!=0) {
						fechaGregorianaIncial=(GregorianCalendar)fechaGregoriana.clone();
						fechaGregorianaIncial.add(Calendar.DATE, 1);
						do {
							fechaGregoriana.add(Calendar.DATE,1);
							if (Arrays.binarySearch(diasNoHabiles,fechaGregoriana.get(Calendar.DAY_OF_WEEK))<0) {
								numeroDeFeriados--;
							}
						} while (numeroDeFeriados!=0);
						numeroDeFeriados=retornaNumeroDeFeriados(fechaGregorianaIncial,fechaGregoriana);
						System.out.println("El numero de feriados entre \""+devuelveFecha(fechaGregorianaIncial)+"\" y \""+devuelveFecha(fechaGregoriana)+"\" es: "+numeroDeFeriados);
					}
				break;
			}
		}
		
		System.out.println(devuelveFecha(fechaGregoriana));
		return fechaGregoriana.getTime();
	}*/
	
}