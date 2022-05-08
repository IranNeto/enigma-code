Enigma
----------
![Coverage](.github/badges/jacoco.svg)


This project aims to structure the Engima Machine behavior in an OO application using TDD, Java 11, Gradle, Spock
This projects simulates how an Enigma machine works under the hood.

### A little background

Enigma, was a cipher machine built by the Nazi Germany to 
encrypt/decrypt secret messages containing war instructions. Messages were sent by radio across all Europe to German
troops but the communication could be intercepted by enemies. However, even in position of the message, the enemies
couldn't interpret it. Only with another engima machine (with the right configuration) could interpret the message as it
was. 

Enigma Machine has definitely its place in human/computer history. The great german machine was widely used during WW2
using a rotors' system with patterns being changed every day. Understand how it works and how Alan Turing managed to break
its code is what moved this project.

More information: https://en.wikipedia.org/wiki/Enigma_machine

### 📋 Pré-requisitos

1. Make sure you have Java 11 and Gradle installed in your machine
2. Download or clone the project
3. Make sure all tests are passing by running 

```
./gradlew clean build test
```

## 📦 Architecture

Enigma is a mechanic machine with a cipher mechanism. So, it is formed by rotors and other parts that have specific behavior.
To represent that in code, and to be easier to write code using TDD, I chose to create an object to every type of part.
They are in `org.iranneto.machinery.parts`. The engima machine is also 'machinery' and that's why is inside the machinery package.

However, only the parts themselves aren't enough to cipher. Given that we have a very defined operation order seems reasonable
to use [Chain of Command pattern](https://www.baeldung.com/chain-of-responsibility-pattern). As it says it's easy to decouple sender and receivers
(all sender and receivers are machinery parts) and if it was an actual project this structure would have the more flexibility 
to add or switch a unit of the chain. They are in `org.iranneto.actions.processors`. The runner and the message passed along the chain
are in `org.iranneto.actions`.

[How the engima works underneath](https://www.youtube.com/watch?v=ybkkiGtJmkM&t=942s&pp=ugMICgJwdBABGAE%3D)

Using TDD was able to cover >93% of the code base.

## 🖇️ Collaboration

Coming soon...

## 📄 Licença

Check out [LICENSE.md](https://github.com/usuario/projeto/licenca) para detalhes.

## 🎁 Expressões de gratidão

* If this was helpful please make sure to star it 📢

* Buy me a coffee or a beer - if you felt in your heart to _hehe_ 🍺

* Thank you 🤓.
---
