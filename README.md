# Mitral AI free key

Go to https://console.mistral.ai/home and create a free API Key (no credit card required);

Build latest `wildfly-ai-feature-pack`:
```shell
git clone git@github.com:wildfly-extras/wildfly-ai-feature-pack.git
cd wildfly-ai-feature-pack
mvn clean install -DskipTests -Denforcer.skip
```

Set Mistral Key:  
```shell
export MISTRAL_API_KEY=...
```

```shell
mvn clean install -DskipTests
```

```shell
./target/server/bin/standalone.sh
```

Point your browser at http://localhost:8080/api/tom
