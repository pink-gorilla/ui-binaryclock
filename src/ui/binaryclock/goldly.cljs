(ns ui.binaryclock.goldly
  (:require
   [pinkie.pinkie :refer-macros [register-component]]
   [ui.binaryclock.clock :refer [binary-clock]]))

(register-component :p/clock binary-clock)
