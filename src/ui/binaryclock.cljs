(ns ui.binaryclock
  (:require
   [reagent.core :as r]))

(defn- cell [n bit]
  [:div.clock-cell {:class (if (bit-test n bit)
                             "light"
                             "dark")}])

(defn- column [n]
  [:div.clock-col
   [cell n 3]
   [cell n 2]
   [cell n 1]
   [cell n 0]
   [:div.clock-cell n]])

(defn- column-pair [n]
  [:div.clock-pair
   [column (quot n 10)]
   [column (mod n 10)]])

(defn- legend [& items]
  (into [:div.clock-col.clock-legend]
        (map (partial vector :div.clock-cell)
             items)))

(defn- ^{:R true}
  clock [date show-100s toggle-100s]
  [:div.clock-main {:on-click toggle-100s
                    :class (when show-100s "wide")}
   [legend 8 4 2 1]
   [column-pair (.getHours date)]
   [column-pair (.getMinutes date)]
   [column-pair (.getSeconds date)]
   (when show-100s
     [column-pair (-> (.getMilliseconds date)
                      (quot 10))])])

(def clock-state (r/atom {:time (js/Date.)
                          :show-100s false}))

(defn- update-time []
  (swap! clock-state assoc :time (js/Date.)))

(defn ^{:R true}
  binary-clock
  "displays a binary clock; on click with seconds.
  useful to debug reagent component that do not update"
  []
  (let [{:keys [time show-100s]} @clock-state]
    (if show-100s
      (r/next-tick update-time)
      (js/setTimeout update-time 1000))
    ^:R
    [clock time show-100s
     #(swap! clock-state update-in [:show-100s] not)]))




