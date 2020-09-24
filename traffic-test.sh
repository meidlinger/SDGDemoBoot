#!/bin/bash
export INGRESS_GATEWAY=`oc get route -n employee | grep employee | awk '{print $2}'`
for i in {0..1000}; do
	curl http://${INGRESS_GATEWAY}/v1/api/sdg/demo/candidate/check/Darren
	curl http://${INGRESS_GATEWAY}/v1/api/sdg/demo/candidate/check/Kenny
	curl http://${INGRESS_GATEWAY}/v1/api/sdg/demo/candidate/check/Mike
	curl http://${INGRESS_GATEWAY}/v1/api/sdg/demo/candidate/titles
done
