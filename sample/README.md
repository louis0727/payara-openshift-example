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

Add the template to your project

```
  oc create -f template.json
```

Create an app in your project based on the payara-example template, e.g. on the Openshift V3 web GUI. The build process should then start automatically.

The example runs the payara glassfish server with an MySQL library for DB connections. An example app is added into the /autodeploy folder which can be accessed

```
  <url>/sample/hello
```

Keep in mind that Docker container must run by default as non root. Openshift runs container with a random user. Therefore all folders and files are made writeable for all user

```
  chmod -R a+w /opt/payara41
```

