package com.codenjoy.dojo.battlecity.model.controller.elements;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 - 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.codenjoy.dojo.battlecity.model.Field;
import com.codenjoy.dojo.battlecity.model.GameSettings;
import com.codenjoy.dojo.battlecity.model.MedKitBonus;
import com.codenjoy.dojo.battlecity.model.controller.ElementController;
import com.codenjoy.dojo.battlecity.model.controller.ElementControllerSettings;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;

import java.util.List;

public class MedKitBonusController extends ElementController<MedKitBonus> {

    public MedKitBonusController(Field fieldController, GameSettings settings, List<MedKitBonus> elements, Dice dice) {
        super(fieldController, settings, elements, dice);
    }

    @Override
    protected MedKitBonus createNewElement(Point point, int lifeCount) {
        return new MedKitBonus(point, lifeCount);
    }

    @Override
    protected ElementControllerSettings getElementSettings(GameSettings gameSettings) {
        ElementControllerSettings settings = new ElementControllerSettings();
        settings.setMinElementLifetime(gameSettings.getMinMedKitBonusLifeTime());
        settings.setMaxElementLifetime(gameSettings.getMaxMedKitBonusLifeTime());
        settings.setMinElementsOnMap(gameSettings.getMinMedKitBonusOnMap());
        settings.setMaxElementsOnMap(gameSettings.getMaxMedKitBonusOnMap());
        settings.setTicksToUpdate(gameSettings.getMedKitBonusGenerationCycle());

        return settings;
    }
}
