import jenkins.model.*;
import hudson.security.*;
import hudson.plugins.sshslaves.*;
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*;
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.domains.*;
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.plugins.credentials.impl.*;
import hudson.security.csrf.*;


void update_user(String user_name, String public_keys="") {
  def user = hudson.model.User.get(user_name);

  if (public_keys != "") {
    def keys_param = new org.jenkinsci.main.modules.cli.auth.ssh.UserPropertyImpl(public_keys);
    user.addProperty(keys_param)
  }
  user.save();
}
