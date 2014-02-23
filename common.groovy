/**
 * Common bnd configurations, e.g. to make package imports optional.
 */
platform {
	// extend/override the default bnd configuration
	// the default bnd configuration does not apply to Jars that are already bundles
	// (to protect the existing imports and exports)
	bnd {
		// sun.* and com.sun.* packages are optional by default
		optionalImport 'sun.*', 'com.sun.*',
			// unit tests only dependencies should be optional as well
			'junit.framework', 'org.junit'
	}
	
	// individual bundle configurations
	
	bnd 'jdom:jdom', {
		optionalImport(
			'oracle.xml.parser',
			'oracle.xml.parser.v2',
			'org.jaxen;resolution',
			'org.jaxen.jdom'
		)
	}
	
	bnd 'net.sf.ehcache:ehcache-core', {
		optionalImport 'org.hibernate', 'org.hibernate.*' // make hibernate optional
	}
	
	bnd(group: 'net.sf.json-lib', name: 'json-lib') {
		optionalImport 'nu.xom', 'org.apache.oro.text.regex'
	}
	
	bnd group: 'xml-apis', name: 'xml-apis', {
		instruction 'Private-Package', 'license' // we don't want to export 'license' as package
	}
	
	bnd group: 'org.apache.ant', name: 'ant', {
		optionalImport 'gnu.gcj', 'kaffe.util', 'org.apache.harmony.luni.util', 'weblogic'
	}
	
	bnd group: 'org.codehaus.groovy.modules.http-builder', name: 'http-builder', {
		optionalImport 'com.google.appengine.api.urlfetch', 'oauth.signpost', 'oauth.signpost.*'
	}
	
	bnd group: 'org.iq80.snappy', name: 'snappy', {
		optionalImport 'org.apache.hadoop.io.compress'
	}
	
	bnd group: 'commons-configuration', name: 'commons-configuration', {
		optionalImport 'org.apache.commons.jxpath', 'org.apache.commons.jxpath.*'
	}
}