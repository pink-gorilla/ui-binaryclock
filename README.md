# BinaryClock [![GitHub Actions status |pink-gorilla/ui-binaryclock](https://github.com/pink-gorilla/ui-binaryclock/workflows/CI/badge.svg)](https://github.com/pink-gorilla/ui-binaryclock/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/ui-binaryclock.svg)](https://clojars.org/org.pinkgorilla/ui-binaryclock)

An example how to create a custom ui renderer for goldly.

## Demo

```
clojure -X:goldly
```

Navigate your webbrowser to port. 
Snippets are in `running systems` / `snippet-registry`

## In Goldly as a ui extension

In deps.edn add quil as dependency and add goldly alias

```
:goldly
  {:extra-deps {org.pinkgorilla/goldly {:mvn/version "0.2.37"}
               {org.pinkgorilla/ui-binaryclock {:mvn/version "0.0.1"}}
   :exec-fn goldly-server.app/goldly-server-run!
   :exec-args {:profile "watch"
               :config {:goldly {:extensions [[ui.binaryclock.goldly]
                                              ]}}}}
```




