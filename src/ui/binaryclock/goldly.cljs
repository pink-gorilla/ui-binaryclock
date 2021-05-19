(ns ui.binaryclock.goldly
  (:require
   [re-frame.core :as rf]
   [pinkie.pinkie :refer-macros [register-component]]
   [ui.binaryclock.clock :refer [binary-clock]]
   [ui.binaryclock.css :as css]))

(register-component :p/clock binary-clock)

(rf/dispatch [:css/add-components css/components css/config])
