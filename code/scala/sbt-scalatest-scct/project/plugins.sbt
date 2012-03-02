resolvers += Classpaths.typesafeResolver

addSbtPlugin("ch.craven" % "scct-plugin" % "0.2")

resolvers ++= Seq(
	"scct-repo" at "http://dimbleby.github.com/maven",
	Resolver.url("Typesafe repository", new java.net.URL("http://typesafe.artifactoryonline.com/typesafe/ivy-releases/"))(Resolver.defaultIvyPatterns)
)
