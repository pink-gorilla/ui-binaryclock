(ns ui.binaryclock.goldly
  (:require
   [goldly.sci.bindings :refer [add-cljs-namespace add-cljs-bindings]]
   [systems.snippet-registry :refer [add-snippet]]))

(add-cljs-namespace [ui.binaryclock.goldly])

(add-snippet {:type :pinkie
              :category :clock
              :id :clock
              :filename "snippets/binaryclock/clock.edn"})