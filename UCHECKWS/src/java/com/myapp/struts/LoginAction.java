/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author ruslan
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private final static String LIST = "list";
    private boolean isError = false;
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionMapping am = mapping;
        ActionForward findForward;
        // extract user data
        LoginForm formBean = (LoginForm) form;
        String name = formBean.getName();
        String email = formBean.getEmail();

        
        
/*        
        // perform validation
        if ((name == null) || // name parameter does not exist
                email == null || // email parameter does not exist
                name.equals("") || // name parameter is empty
                email.indexOf("@") == -1) {   // email lacks '@'

            formBean.setError();
            return mapping.findForward(FAILURE);
        }
*/

        /*
                // Set up environment for creating initial context
        @SuppressWarnings("UseOfObsoleteCollectionType")
	Hashtable env = new Hashtable(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/ou=clients,dc=hs,dc=mnote,dc=ru");
        
        
        // Authenticate as S. User and password "mysecret"
	env.put(Context.SECURITY_AUTHENTICATION, "simple");
	//env.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=mnote,dc=ru");
        env.put(Context.SECURITY_PRINCIPAL, "cn=" + name + ",ou=clients,dc=hs,dc=mnote,dc=ru");
	env.put(Context.SECURITY_CREDENTIALS, email);
        
          try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    //System.out.println(ctx.lookup("(title=*)"));

            
	    // do something useful with ctx

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
            //isError = true;
	    //findForward = mapping.findForward(FAILURE);
            //return findForward;
            //e.printStackTrace();
            //return am.findForward(SUCCESS);

            formBean.setError();
            return am.findForward(FAILURE);
	}
        */
        
          /*
         if (isError) 
         {
             return am.findForward(FAILURE);
         } else {
             
             return am.findForward(SUCCESS);
         }
       */
        //return mapping.findForward(SUCCESS);
         return mapping.findForward(LIST);
    }
}
