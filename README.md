
Example for [shadow-cljs](https://github.com/thheller/shadow-cljs)
----

## 1. 启动node-repl

```bash
➜  minimal-shadow-cljs-commonjs git:(master) ✗ shadow-cljs node-repl
shadow-cljs - socket REPL running on port 53372

[0:0]~cljs.user=> (require 'example.main) => ## nil
[0:0]~cljs.user=> (example.main/main)
object[Stream [object Object]]
[0:0]~cljs.user=> {"origin":"183.240.196.145"}

```

## 2. Emacs连接node-repl
```bash
M-x cider-connect-cljs 127.0.0.1:53372

shadow.user> (node-repl)
To quit, type: :cljs/quit
[:selected :node-repl]
cljs.user>
cljs.user> (require 'example.main)
nil
cljs.user> (example.main/main)
#object[Stream [object Object]]
cljs.user>
cljs.user>


```

------------


### Usage

Compile ClojureScript into CommonJS JavaScript:

```bash
yarn
yarn compile
```

Browse `target/` folder to see the results. You can check CommonJS result with `node`:

```bash
$ node
> require('./target/example.main').main()
App loaded!
null
>
```

##### Advanced

Watch and compile:

```bash
$ yarn shadow-cljs watch app
$ node
> require('./target/example.main').main()
App loaded!
null
>
```

Compiled with dead code eliminations:

```basn
$ yarn shadow-cljs release app
$ node
> require('./target/release/example.main').main()
App loaded!
null
>
```

### Steps

To setup in a new project:

* `yarn add --dev shadow-cljs`
* configure `shadow-cljs.edn`
* compile with commands

##### For `release` mode

Notice that in release, in order to build in `:advanced`, `:entries` is required:

```edn
  {; ...
   :release {:entries [example.main]
             :output-dir "target/release/"}}
```

And configs of `:release` will overwrite previous configs.

### License

MIT
