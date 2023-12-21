# Use Kotlin to send HTTP(s) requests from inside WASM (Node.js and Deno) 

## Instructions for this devcontainer

Tested with kotlin("multiplatform") version 1.9.21, Node 22.0.0, Deno 1.39.1 .

### Preparation

1. Open this repo in devcontainer, e.g. using Github Codespaces.
   Type or copy/paste following commands to devcontainer's terminal.

### Building

1. `cd` into the folder of this example:

```sh
cd node-and-deno
```

2. Compile the example:

```sh
./gradlew build
```

The compilation result will be in `./build/js/packages/node-example-wasm-js/kotlin/` folder.

### Test with Node.js

1. Run with Node:

```sh
./gradlew wasmJsNodeRun
```

This task will download WASM-GC-enabled build of Node (22.0.0-v8-canary) and will run the `node-example-wasm-js.mjs` with it.

### Test with Deno

1. Install Deno:

```sh
curl -fsSL https://deno.land/x/install/install.sh | sh
```

2. Apply a small patch to `node-example-wasm-js.uninstantiated.mjs` to allow it run in Deno:

```sh
sed -si.bak 's/const isNodeJs =.*/const isNodeJs = true/' build/js/packages/node-example-wasm-js/kotlin/node-example-wasm-js.uninstantiated.mjs
```

3. Run with Deno:

```sh
~/.deno/bin/deno run --allow-read --allow-net build/js/packages/node-example-wasm-js/kotlin/node-example-wasm-js.mjs
```

### Finish

Perform your own experiments if desired.
