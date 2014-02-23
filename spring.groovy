/*
 * Include Spring core bundles and ensure a common version for spring bundles.
 */
def springCore(String springVersion = '3.1.1.RELEASE') {
	def springGroup = 'org.springframework'
	
	configurations {
		platform {
			resolutionStrategy.eachDependency {
				if (it.requested.group == orientGroup) {
					it.useTarget(
						group: it.requested.group,
						name: it.requested.name,
						version: springVersion // fixed version for all spring dependencies
					)
				}
			}
		}
	}
	
	platform {
		bundle group: springGroup, name: 'spring-core', version: springVersion
	}
}

/*
 * Add spring core and a set of default bundles to the platform.
 */
def spring(String springVersion = '3.1.1.RELEASE') {
	def springGroup = 'org.springframework'
	springCore(springVersion)
	
	/*
	 * XXX for some reason gradle has problems resolving the dependencies if no specific version is
	 * given (even though for each dependency a fixed version should be applied via springCore(...))
	 */
	platform {
		bundle group: springGroup, name: 'spring-beans', version: springVersion
		bundle group: springGroup, name: 'spring-context', version: springVersion
		bundle group: springGroup, name: 'spring-context-support', version: springVersion
	}
}