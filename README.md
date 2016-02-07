Openshift V3 Payara 4.1 Glassfish example
==============================

Login to your Openshift instance

```
  oc login
```

If there is no project create a project 

```
  oc new-project yourproject
```

Add the example as an app

```
  oc new-app https://github.com/snoopyCode/payara-openshift-example.git
```

The example runs the payara glassfish server with an MySQL library for DB connections. An example app is added into the /autodeploy folder which can be accessed

```
  <url>/sample/hello
```

Keep in mind that Docker container must run by default as non root. Openshift runs container with a random user. Therefore all folders and files are made writeable for all user

```
  chmod -R a+w /opt/payara41
```

