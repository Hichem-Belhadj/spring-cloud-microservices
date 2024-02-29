
# Exploring Microservices with Spring Cloud: Containerization, Resilience, and Communication

Welcome to our GitHub repository dedicated to experimenting with microservices architecture using Spring Cloud. This project delves deep into fundamental principles such as service registry, API Gateway, centralized configuration service with a remote repository, as well as resilience implementation and communication between microservices. Additionally, we've tackled the containerization of both services and the Angular frontend using Docker, providing a comprehensive and easily deployable approach for developing and managing our microservices-based applications. Explore our repository to discover our architectural choices, implementations, and best practices in the exciting realm of microservices with Spring Cloud.



### 📁 File Structure

```
├── back
│   ├── account-service:8082
│   ├── customer-service:8081
│   ├── config-service:9999
│   ├── discovery-service:8761
│   ├── gateway-service:8888
│   └── config-git-repo
│
└── front
```

### 📡SonarQube & Jacoco

 By following our concise installation instructions, you'll seamlessly incorporate SonarQube's powerful code quality analysis capabilities alongside JaCoCo's code coverage reporting. Enhance your development workflow and ensure code quality with this simple yet effective integration.

#### ⚙️ Install

- Download the community version of SonarQube [here](https://www.sonarsource.com/products/sonarqube/downloads/)
- Go to your ```[SonarQube folder path]/bin/[your operating system]/lib``` folder and run ```StartSonar.bat```
- You can now access SonarQube from ```http://localhost:9000```
- You will be asked to log in using the **```admin```** ID and **```admin```** password, and then to change your password.
- Generate your security token from **myAccount/security**

#### 🌱 Spring Boot

- Go to your project's **pom.xml** file and add the following two plugins:
```
<plugin>
    <groupId>org.sonarsource.scanner.maven</groupId>
    <artifactId>sonar-maven-plugin</artifactId>
</plugin>

<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.11</version>
    <executions>
        <execution>
            <id>prepare-agent</id>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
- Run the following Maven command:

```
clean org.jacoco:jacoco-maven-plugin:prepare-agent Install
```
*The jacoco folder should appear in your project's ```target/site``` folder.*
- Run the following maven command:
```
sonar:sonar -Dsonar.login=[your security token]
```

### 🅰️ Angular

- Install Karma & Jasmine:
```
npm install karma --save-dev
npm install karma-jasmine --save-dev
```
- Create Karma conf file:
```
node_modules\.bin\karma init
```
- Install Karma-SonarQube:
```
npm install -D karma-sonarqube-reporter --save-dev
```
- Run the following command and check for the presence of the file **```reports/sonarqube_report.xml```**:
```
ng test --code-coverage --watch=false
```
- Install sonar-scanner:
```
npm install -D sonarqube-scanner --save-dev
```
- Add your sonar token to the file **```sonar-project.properties```**
- Run the Sonar command:
```
npm run sonar
```

## Deployment

### 🅰️ Angular

To buil this Angular project run:
```
ng build
```

#### 🌱 Spring Boot

- For each service to be deployed, you'll need to create a .jar file. To do this, run the following Maven command:
```
clean package -DskipTests
```
- Run the services by executing the following Docker command:
```
docker compose up -d --build
```