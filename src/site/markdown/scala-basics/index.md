## Introduction

**Scala allows to use a functional programming style, but can also be used as a full fledged object oriented programming language as well.**

It can be seen as a missing link between enterprise development (a domain where Java has its strengths) and pure functional programming (Haskell comes to mind). Like this, both worlds profit, and at the end more efficient software can be written.

In this chapter, we'll talk briefly about the history of Scala, it's current state and where current developments are heading to. After that, we'll have a look at basic Scala syntax, for example we'll examine _classes_, _traits_, _objects_, _for comprehensions_ and so on. 

Please bear in mind that this chapter only gives a very short, incomplete and simplified view on the Scala language. There are many resources available online for learning Scala, a good starting point would be [www.scala-lang.org](http://www.scala-lang.org). The discussion here should serve as a starting point, provide you with the bare minimum to start and to be able to write useful programs.

Standard literature for learning Scala is the book [Programming in Scala, 1st edition (online version)](http://www.artima.com/pins1ed/) by Odersky, Spoon and Venners. In the meantime it has its 3rd edition, available in your favorite bookstore. Another great book which uses Scala as vehicle for teaching functional programming concepts would be [Functional Programming in Scala](https://www.manning.com/books/functional-programming-in-scala) by Chiusano and Bjarnason.

Reading both titles is **highly** recommended, it will give you better insights in programming in general and will be very helpful for mastering this course. 


### History

It has been developed by [Martin Odersky](https://twitter.com/odersky), a professor at EPFL and is now backed by a company called Lightbend which provides commercial support for Scala and its ecosystem. 

Scala and its core libraries have been under constant improvement already since more than a decade. 

The third version of the language and its compilers has been in the works already since about 4 years and is based on a formal proven type system which is essential for future growth of the language and its concepts.

### Environments

Scala targets the _JVM_ as its primary runtime environment, where interoperability with other JVM based languages like of course Java, Clojure, Kotlin and the like is a major selling point for the language. 

Moreover, there exists a compiler infrastructure to generate _Javascript_ out of Scala source code, which brings type safety to the realms of Javascript programming. Here, Typescript is a comparable platform.

Only recently an AOT ([_Ahead of time compilation_](https://en.wikipedia.org/wiki/Ahead-of-time_compilation)) compiler chain for Scala was developed to generate _LLVM_ bitcode. Using this AOT compiler, it is possible to generate native executables and be independent of the JVM. 

### Adoption

Scala is endorsed by many major companies like Apple, IBM, Linkedin, SAP, Twitter etc.


 