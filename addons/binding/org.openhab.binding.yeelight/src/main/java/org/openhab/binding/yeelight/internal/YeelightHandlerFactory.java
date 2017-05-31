/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.yeelight.internal;

import static org.openhab.binding.yeelight.YeelightBindingConstants.*;

import java.util.Set;

import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.yeelight.handler.YeelightCeilingHandler;
import org.openhab.binding.yeelight.handler.YeelightColorHandler;
import org.openhab.binding.yeelight.handler.YeelightStripeHandler;
import org.openhab.binding.yeelight.handler.YeelightWhiteHandler;

import com.google.common.collect.Sets;

/**
 *
 * @author Coaster Li (lixin@yeelink.net) - Initial contribution
 */
public class YeelightHandlerFactory extends BaseThingHandlerFactory {

    public final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Sets.newHashSet(THING_TYPE_CEILING,
            THING_TYPE_DOLPHIN, THING_TYPE_WONDER, THING_TYPE_STRIPE);

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {

        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(THING_TYPE_DOLPHIN)) {
            return new YeelightWhiteHandler(thing);
        } else if (thingTypeUID.equals(THING_TYPE_WONDER)) {
            return new YeelightColorHandler(thing);
        } else if (thingTypeUID.equals(THING_TYPE_STRIPE)) {
            return new YeelightStripeHandler(thing);
        } else if (thingTypeUID.equals(THING_TYPE_CEILING)) {
            return new YeelightCeilingHandler(thing);
        } else {
            return null;
        }
    }
}
