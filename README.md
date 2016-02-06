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

The example runs the payara glassfish server with an MySQL library for DB connections. An example app is added which can be accessed by

```
  /restexample/hello
```

