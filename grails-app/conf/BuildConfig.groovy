grails.project.work.dir = 'target'

grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
        mavenRepo 'http://dl.bintray.com/karman/karman'
    }

    plugins {
        runtime ":asset-pipeline:1.9.9"

        if (System.getProperty('plugin.mode') != 'local') {
            runtime ":selfie:0.3.5"
            runtime ":spud-core:0.6.1"

            runtime(':hibernate4:4.3.5.4') {
                export = false
            }
        }

        build ':release:3.0.1', ':rest-client-builder:2.0.3', {
            export = false
        }
    }
}

if (System.getProperty('plugin.mode') == 'local') {
    grails.plugin.location."spud-core" = "../spud-core"
    grails.plugin.location."selfie" = "../../plugins/selfie"
}
