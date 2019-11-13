# graal-example

A sample project starter compiling with GraalVM native image.

## Building and running from source

### Requirements:
- An OS supported by the JVM
- [Graal VM](https://www.graalvm.org/downloads/)

### Installing GraalVM for native compilation:
- Download GraalVm CE from https://www.graalvm.org/downloads/
- Extract it to a location navigate to the directory where you can find bin, lib, jre directoires
- Set an 2 environemnt vars `GRAALVM_HOME` and `JAVA_HOME` to this directory
- Install Leiningen https://leiningen.org/
- Run `$GRAALVM_HOME/bin/gu install native-image` to install the native tooling for Graal

### Editor setup:
- [Emacs](https://cider.mx/)
- [IntelliJ](https://cursive-ide.com/) (Get a free license by choosing Non-Commercial License)
- [Vim](https://github.com/tpope/vim-fireplace)
- [VSCode](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva)
- [Atom](https://atom.io/packages/chlorine)

### Test if setup is fine:
- Make sure all of the Graal installation steps went fine
- Clone this repo
- Run "lein native-image"
- *Lots of minutes later...* you should have a file in: `/target/default+uberjar/graal-example`.
- Running `./target/default+uberjar/graal-example` should produce:
  ```json
  {
      "name" : "Amazon.com Inc",
      "price" : 1778
  }
  ```
