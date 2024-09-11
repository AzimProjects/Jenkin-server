import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

// Create an admin user
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('admin', 'adminpassword')
instance.setSecurityRealm(hudsonRealm)

// Set up authorization strategy
def strategy = new GlobalMatrixAuthorizationStrategy()
strategy.add(Jenkins.ADMINISTER, 'admin')
instance.setAuthorizationStrategy(strategy)

// Save changes
instance.save()
