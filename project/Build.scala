import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "hssy"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      javaCore,
      "mysql" % "mysql-connector-java" % "5.1.29",
      "org.springframework" % "spring-aop" % "3.2.3.RELEASE",
      "org.springframework" % "spring-aspects" % "3.2.3.RELEASE",
      "org.springframework" % "spring-core" % "3.2.3.RELEASE",
      "org.springframework" % "spring-context" % "3.2.3.RELEASE",
      "org.springframework" % "spring-context-support" % "3.2.3.RELEASE",
      "org.springframework" % "spring-expression" % "3.2.3.RELEASE",
      "org.springframework" % "spring-orm" % "3.2.3.RELEASE",
      "org.springframework" % "spring-jdbc" % "3.2.3.RELEASE",
      "org.springframework" % "spring-tx" % "3.2.3.RELEASE",
      "org.springframework" % "spring-test" % "3.2.3.RELEASE",
      "org.springframework.data" % "spring-data-jpa" % "1.4.2.RELEASE",
      "org.hibernate" % "hibernate-entitymanager" % "4.2.2.Final",
      "commons-dbcp" % "commons-dbcp" % "1.4",
      "commons-beanutils" % "commons-beanutils" % "1.9.1",
      "commons-io" % "commons-io" % "2.4",
      "junit" % "junit" % "4.11",
      "com.thoughtworks.xstream" % "xstream" % "1.4.5",
      "org.modelmapper" % "modelmapper" % "0.6.2",
      "org.slf4j" % "slf4j-log4j12" % "1.7.5",
      "org.aspectj" % "aspectjweaver" % "1.6.12",
      "joda-time" % "joda-time" % "2.2",
      "org.apache.commons" % "commons-collections4" % "4.0",
      "org.apache.httpcomponents" % "httpclient" % "4.3.5",
      "org.apache.httpcomponents" % "httpcore" % "4.3.2",
      "org.apache.httpcomponents" % "httpmime" % "4.3.5",
      "com.google.code.gson" % "gson" % "2.2.4",
      "org.quartz-scheduler" % "quartz" % "2.1.6",
      "org.apache.axis2" % "axis2-adb" % "1.6.2",
      "org.apache.axis2" % "axis2-transport-local" % "1.6.2",
      "org.apache.axis2" % "axis2-transport-http" % "1.6.2",
	  "org.json" % "json" % "20080701",
	  "com.mchange" % "c3p0" % "0.9.2.1",
	  "com.sun.xml.fastinfoset" % "FastInfoset" % "1.2.12",
      "com.sun.xml.bind" % "jaxb-impl" % "2.2.7",
      "org.jdom" % "jdom" % "2.0.1"
       
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here      
    )
	
}
