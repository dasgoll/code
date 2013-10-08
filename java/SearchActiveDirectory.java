import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class SearchActiveDirectory {

	public static void main(String[] args) {
		SearchActiveDirectory retrieveUserAttributes = new SearchActiveDirectory();
		retrieveUserAttributes.getUserBasicAttributes("iphone", retrieveUserAttributes.getLdapContext());
	}

	public LdapContext getLdapContext(){
		LdapContext ctx = null;
		try{
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.SECURITY_AUTHENTICATION, "Simple");
//			env.put(Context.SECURITY_PRINCIPAL, "jaaraidah@nu.edu.sa");
			env.put(Context.SECURITY_PRINCIPAL, "CN=jaaraidah,OU=EMPLOYEES,OU=MALE,OU=NAJRAN,DC=nu,DC=edu,DC=sa");
			env.put(Context.SECURITY_CREDENTIALS, "mirclolo_89");
			env.put(Context.PROVIDER_URL, "ldap://172.18.18.24:389");
			ctx = new InitialLdapContext(env, null);
			System.out.println("Connection Successful.");
		}catch(NamingException nex){
			System.out.println("LDAP Connection: FAILED");
			nex.printStackTrace();
		}
		return ctx;
	}

	private void getUserBasicAttributes(String username, LdapContext ctx) {
		try {
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String[] attrIDs = { "distinguishedName", "sn", "givenname", "mail", "telephonenumber"};
			constraints.setReturningAttributes(attrIDs);
			//First input parameter is search bas, it can be "CN=Users,DC=YourDomain,DC=com"
			//Second Attribute can be uid=username
			NamingEnumeration answer = ctx.search("ou=TEST,dc=nu,dc=edu,dc=sa", "sAMAccountName=" + username, constraints);
			if (answer.hasMore()) {
				Attributes attrs = ((SearchResult) answer.next()).getAttributes();
//				System.out.println(attrs.get("distinguishedName"));
				System.out.println(attrs.get("givenname"));
//				System.out.println(attrs.get("sn"));
//				System.out.println(attrs.get("mail"));
//				System.out.println(attrs.get("telephonenumber"));
			}else{
				throw new Exception("Invalid User");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;
	}
}