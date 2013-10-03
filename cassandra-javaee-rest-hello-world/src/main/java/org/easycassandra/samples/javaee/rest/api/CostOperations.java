package org.easycassandra.samples.javaee.rest.api;

import java.util.List;

/**
 *
 * @author otaviojava
 */
public interface CostOperations {
    
    boolean save(CostUnit bean);
    
    boolean update(CostUnit bean);
    
    boolean delete(String cityName);
    
    List<CostUnit> list();
    
    CostUnit retrieve(String city);
    
    
}
