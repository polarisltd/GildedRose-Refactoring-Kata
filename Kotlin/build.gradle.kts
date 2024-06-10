plugins {
	kotlin("jvm") version "1.9.10"
	application
	id("io.gitlab.arturbosch.detekt") version("1.23.3")
}

group = "com.gildedrose"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))
	testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
}

java {
	targetCompatibility = JavaVersion.VERSION_11
}

application {
	mainClass.set("com.gildedrose.TexttestFixtureKt")
}



