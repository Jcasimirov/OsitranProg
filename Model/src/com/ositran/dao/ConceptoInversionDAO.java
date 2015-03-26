
package com.ositran.dao;

import com.ositran.model.ConceptoInversion;

import java.sql.SQLException;

import java.util.List;

public interface ConceptoInversionDAO {
    public List<ConceptoInversion> query() throws SQLException;
}
