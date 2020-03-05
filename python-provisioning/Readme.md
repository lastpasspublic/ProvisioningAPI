This Python project contains several code samples about how to interact with LastPass services.

**Users Provisioning:**

    A sample code that shows how to interact with LastPass API to manage users, groups, group members and roles.
    Users provisioning API exchanges JSON encrypted messages. 
    
    In order to start using the API you must:
    - Provide a RSA public an private key in PEM format.
    - Register public key at LastPass.
    - Set generic API key in config.properties file. Copy key value from LastPass Admin portal - Keys - Generic API.
    
    A working sample can be found at UsersProvisioningSample.py.