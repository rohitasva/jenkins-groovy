import jenkins.model.*;
import hudson.security.*;
import hudson.security.csrf.*;

def server = "<LDAP server name>"
def rootDN = ""
def userSearchBase = "<Search Base for LDAP User>"
def userSearchFilter = "<Search Filter for LDAP User>"
def groupSearchBase = "<Serach Base for LDAP Group>"
def groupSearchFilter = "<Serach Filter for LDAP Group>"
def managerDN = "<LDAP Manager account>"
def managerPasswd = "<LDAP Manager passwd>"

def securityRealm = new LDAPSecurityRealm(server, rootDN, userSearchBase, userSearchFilter, groupSearchBase,
                                        groupSearchFilter, null, managerDN, managerPasswd,
                                        true,  // false if rootDN is not empty
                                        false, null, null);

Jenkins.instance.setSecurityRealm(securityRealm)
Jenkins.instance.save()
