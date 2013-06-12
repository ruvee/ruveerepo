/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mnote.ws;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ru.mnote.jdb.MSSQLLogic;

/**
 *
 * @author Руслан
 */
@WebService(serviceName = "UProcessWS")
public class UProcessWS {

    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "op")
    public Boolean op(@WebParam(name = "id") String id, @WebParam(name = "procs") String procs, @WebParam(name = "val") double val, @WebParam(name = "prev") double prev) {
        //TODO write your implementation code here:
        
        MSSQLLogic dblogic = new MSSQLLogic();
 
        //String SQL = "INSERT INTO data (procs, val, prev, date) VALUES ('b',1,2,getdate())";
        //String SQL = "INSERT INTO " + tablename + " (" + columns + ") VALUES (" + values + ")";
        
        dblogic.connect();
        dblogic.executeUpdateStatement(
                 "data",
                 "procs, val, prev, date",
                 "\'" + procs + "\'," + val + "," + prev + "," + "getdate()");
        
        return true;
    }
}
