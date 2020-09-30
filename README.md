# sdgdemoboot

## Service Mesh Integration

### Add Application Label

```
template:
  metadata:
    labels:
      app: springboot-demo
```

```
oc patch deployment.apps/springboot-demo -p '{"spec":{"template":{"metadata":{"labels":{"app": "springboot-demo" }}}}}'
oc patch deploymentconfig.apps.openshift.io/mysql -p '{"spec":{"template":{"metadata":{"labels":{"app": "mysql" }}}}}'
```


### Add Sidecar

```
template:
  metadata:
    annotations:
      sidecar.istio.io/inject: "true"
```

```
oc patch deployment.apps/springboot-demo -p '{"spec":{"template":{"metadata":{"annotations":{"sidecar.istio.io/inject": "true" }}}}}'
oc patch deploymentconfig.apps.openshift.io/mysql -p '{"spec":{"template":{"metadata":{"annotations":{"sidecar.istio.io/inject": "true" }}}}}'
```

### Loading Service Mesh Resources

```
oc create -f https://raw.githubusercontent.com/meidlinger/sdgdemoboot/master/ossm/sdgdemo.yaml
oc create -f https://raw.githubusercontent.com/meidlinger/sdgdemoboot/master/ossm/sdgsmdemo-gateway.yaml
oc create -f https://raw.githubusercontent.com/meidlinger/sdgdemoboot/master/ossm/sdgdemo-destin-rule.yaml
```

