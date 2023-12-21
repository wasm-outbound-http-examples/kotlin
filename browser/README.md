# Use Kotlin to send HTTP(s) requests from inside WASM in Browser

## Instructions for this devcontainer

Tested with kotlin("multiplatform") version 1.9.21. This sample is partially based on [Kotlin's own examples](https://github.com/Kotlin/kotlin-wasm-examples/tree/ea1a989bbf179dfccbc970d73e41d128e1b965af/browser-example).

### Preparation

1. Open this repo in devcontainer, e.g. using Github Codespaces.
   Type or copy/paste following commands to devcontainer's terminal.

### Building

1. `cd` into the folder of this example:

```sh
cd browser
```

2. Compile the example:

```sh
./gradlew build
```

### Test with browser

1. Run debug HTTP server to temporarily publish project to Web:

```sh
./gradlew wasmJsBrowserRun
```

Codespace will show you "Open in Browser" button. Just click that button or
obtain web address from "Forwarded Ports" tab.

2. As `index.html` and a 52k-sized `browser-example-wasm-js.wasm` are loaded into browser, refer to browser developer console
   to see the results.

3. If you want to publish this on your own server, you can run bundling by:

```sh
./gradlew wasmJsBrowserDistribution
```

The bundling result will be in `./build/dist/wasmJs/productionExecutable/` folder.

### Finish

Perform your own experiments if desired.
