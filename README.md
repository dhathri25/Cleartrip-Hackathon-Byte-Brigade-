Here is your complete, raw text **`README.md`** file content formatted exactly for copy-pasting into your file.

# Cleartrip Test Automation Framework

An enterprise-grade automated UI testing suite designed to validate the core flight search pipeline, overlay management, and dynamic routing engines of the Cleartrip platform. This framework is engineered using the Page Object Model (POM) architectural design pattern to ensure scalability, modularity, and high maintainability.

---

## Architectural and Operational Capabilities

* **Asynchronous Synchronization Guard**: Replaced brittle, hardcoded `Thread.sleep` blocks with dynamic explicit waits (`WebDriverWait`). The system continuously polls the DOM tree structure, accelerating execution by proceeding the exact millisecond components like autocomplete widgets and lazy-loaded result matrix grids render.
* **Inline Failure Artifact Injection**: Configured with real-time TestNG event listeners that intercept exceptions instantly. On a test failure, the framework forces a viewport snapshot via the Selenium API and attaches the graphic directly inside the reporting stream.
* **Thread-Safe Log Allocation**: Implements a `ThreadLocal` wrapper around the Extent Reports logging allocation engine, preventing log bleeding or reporting overlap during multi-threaded test cycles.
* **Externalized Parameterization Map**: Decouples runtime operational metrics (such as destination endpoints, URLs, and timing constants) from the compilation logic, externalizing them fully into localized resource files.

---

## Framework Structural Hierarchy

The project file tree separates operational logic, data repositories, and verification criteria:

```text
cleartriphackathon
├── src/main/java
│   ├── com.cleartrip.base
│   │   └── BaseClass.java         # Driver instantiation and screenshot capturing rules
│   ├── com.cleartrip.pages
│   │   └── FlightSearchPage.java  # Real-time locator mappings and explicit page routines
│   └── com.cleartrip.utils
│       ├── ConfigReader.java      # Property file IO streaming adapters
│       ├── ExtentManager.java     # HTML reporting engine configurations
│       ├── Listeners.java         # TestNG execution event listener adapters
│       └── WaitUtils.java         # Centralized explicit wait synchronization libraries
├── src/main/resources
│   └── config.properties          # Runtime parameters configuration resource
├── src/test/java
│   └── com.cleartrip.tests
│       └── FlightSearchTest.java  # TestNG execution pipeline workflows
├── src/test/resources
│   └── testng.xml                 # Multi-suite execution and listener configuration
├── reports
│   └── ExtentReport.html          # Generated test run performance metrics dashboards
└── pom.xml                        # Project Object Model dependencies manifest

```

---

## Local System Prerequisites

To compile and execute the test suites natively, ensure your machine satisfies these configuration bounds:

* **Java Development Kit**: JDK 11 or higher installed and mapped to system variables.
* **Apache Maven**: Build lifecycle management binary installation (v3.8+ recommended).
* **Google Chrome**: Stable local application release binary matching the Selenium instance driver layer.

---

## Configuration Parameter Management (config.properties)

Define your environment scope within `src/main/resources/config.properties`. Update these fields before running the tests:

```properties
url=https://www.cleartrip.com/
fromCity=Hyderabad
toCity=Delhi
targetDepartureDate=Mon Jun 15 2026
browser=chrome

```

---

## Compilation and Test Execution Directives

Run these commands from the terminal window at your project root directory:

### Reset Project Cache

```bash
mvn clean

```

### Run Test Suite Execution Lifecycle

```bash
mvn test

```

### Generate Independent Surefire Execution Report

```bash
mvn surefire-report:report

```

---

## Execution Metric Reporting and Analysis

On framework execution completion, test run data is synthesized into an external tracking view.

* **Report Distribution Location**: Navigate to `cleartriphackathon/reports/ExtentReport.html` and open it via any modern web browser.
* **Exception Logging Matrix**: If a test step validation throws an error, the corresponding node inside the report interface expands to present the explicit stack trace alongside an inline view of the screenshot captured at the exact moment of failure.

---

## Contribution and Version Control Guidelines

When modifying existing routines or adding features, follow this branch isolation cycle:

1. Sync your local machine workspace with the remote source repository:
```bash
git checkout main
git pull origin main
git checkout -b feature/your-feature-name

```


2. Commit changes after ensuring your code compiles and passes locally:
```bash
mvn clean test

```


3. Stage your tracking changes and push the isolated feature up to the server:
```bash
git add .
git commit -m "Brief and specific summary of structural updates"
git push origin 

```