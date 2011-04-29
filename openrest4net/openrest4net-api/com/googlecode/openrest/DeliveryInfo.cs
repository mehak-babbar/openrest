﻿using System;
using Newtonsoft.Json;
using System.Collections.Generic;

namespace com.googlecode.openrest
{
    /**
     * Information regarding a delivery destination: type, area, requirements, etc.
     * @author DL
     */
    public class DeliveryInfo
    {
        public DeliveryInfo(string type, Area area, int minOrderPrice, int charge, int delayMins)
        {
            this.type = type;
            this.area = area;
            this.minOrderPrice = minOrderPrice;
            this.charge = charge;
            this.delayMins = delayMins;
        }

        /** Empty constructor required for initialization from JSON-encoded string. */
        public DeliveryInfo() { }

        /** Delivery type, one of Delivery.ALL_DELIVERY_TYPES. */
        public string type;
    
        /** Optional delivery area (for type = Delivery.DELIVERY_TYPE_DELIVERY). */
        public Area area;
    
        /** The minimum allowed order price (in "cents"). */
        public int? minOrderPrice = 0;
    
        /** The delivery charge (in "cents"). */
        public int? charge = 0;
    
        /** Delivery time (maximum number of minutes till order arrives). */
        public int? delayMins = 0;
    }
}