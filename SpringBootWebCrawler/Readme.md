# WebCrawler

WebCrawler is a simple REST webservice with a single end point built on Spring Boot.   
- Takes two inputs - Source Url and the Depth to which crawling should happen.
- The crawl results are returned as a list of urls in a tree structure.
- For a simple url like http://wiprodigital.com/ with a depth of 2, it will take around 30 seconds for the crawling to finish.

## How to run!

  - WebCrawlers-0.0.1-SNAPSHOT is available in the target folder.
  - Set Java Path and execute the command `java -jar WebCrawlers-0.0.1-SNAPSHOT.jar`
  - Hit the url http://localhost:8080/crawl
  - A sample request would look like below
  {
	"baseUrl" : "http://wiprodigital.com/",
	"depth" : 2
}
 
## What can be done to improve?

  - Instead of HTML parsers build a TextParser using streams to improve performance.
  - Currently this will read only href from the web. Since more and more js are out there this should be enhanced to get ur from there as well.
  - Currently we have single thread parsing a single url. Crawling can be executed in a multi threaded environment using Executor services.
  - Save the data into the DB periodically so that we doesn't run out of heap space.
  - The saved data can be loaded into a cache and in case of db connection issues, this can be used as a backup using Hysterix.