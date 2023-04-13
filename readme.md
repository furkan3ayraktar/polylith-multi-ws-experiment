<img src="logo.png" width="30%" alt="Polylith" id="logo">

The Polylith documentation can be found here:

- The [high-level documentation](https://polylith.gitbook.io/polylith)
- The [Polylith Tool documentation](https://polylith.gitbook.io/polylith/poly)
- The [RealWorld example app documentation](https://github.com/furkan3ayraktar/clojure-polylith-realworld-example-app)

You can also get in touch with the Polylith Team on [Slack](https://clojurians.slack.com/archives/C013B7MQHJQ).

# [Experimental] Multi-Workspace & Multi-Dialect Polylith Repository

This is an experimental workspace showing how a Polylith workspace may look like if Polylith
supported multiple workspaces in the same repository with multiple dialects.

> See disucussion at https://github.com/polyfy/polylith/discussions/301.

## Start a REPL in VSCode / Calva

1. Fork & clone this repo
2. Open the project in VSCode
    * [Install the Calva extension](https://calva.io/getting-started/#install-vs-code-and-calva), if you don't have it installed alreaady.
3. Press F1 and select `Calva: Start a Project REPL and Connect (aka Jack-In)`

Calva will start Clojure and ClojureScript REPLs using [shadow-cljs](https://github.com/thheller/shadow-cljs).
- It will start a web server at http://localhost:6003
- It will start the frontend application at http://localhost:3000

This project demonstrates how two Polylith workspaces can share components and how we can have a
single Jack-In session and have both Clojure and ClojureScript REPLs. Calva will automatically
switch to correct REPL based on the file you are in.
