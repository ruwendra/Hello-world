pipeline {
		agent any
		
		stages {
			stage ('compile Stage') {
				
				steps {
					withMaven(maven : 'maven_3.5.4') {
						sh 'mvn clean compile'
						
					}
				}
			}
			stage ('Testing Stage') {
				steps {
					withMaven(maven : 'maven_3.5.4') {
						sh 'mvn test'
					}
				}
			}
			stage ('Deployment Stage') {
				steps {
					withMaven(maven : 'maven_3.5.4') {
						sh 'mvn deploy'
					}
				}
			}
		}
}