/*******************************************************************************
 * CogTool Copyright Notice and Distribution Terms
 * CogTool 1.2, Copyright (c) 2005-2013 Carnegie Mellon University
 * This software is distributed under the terms of the FSF Lesser
 * Gnu Public License (see LGPL.txt). 
 * 
 * CogTool is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 * 
 * CogTool is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with CogTool; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 * CogTool makes use of several third-party components, with the 
 * following notices:
 * 
 * Eclipse SWT
 * Eclipse GEF Draw2D
 * 
 * Unless otherwise indicated, all Content made available by the Eclipse 
 * Foundation is provided to you under the terms and conditions of the Eclipse 
 * Public License Version 1.0 ("EPL"). A copy of the EPL is provided with this 
 * Content and is also available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * CLISP
 * 
 * Copyright (c) Sam Steingold, Bruno Haible 2001-2006
 * This software is distributed under the terms of the FSF Gnu Public License.
 * See COPYRIGHT file in clisp installation folder for more information.
 * 
 * ACT-R 6.0
 * 
 * Copyright (c) 1998-2007 Dan Bothell, Mike Byrne, Christian Lebiere & 
 *                         John R Anderson. 
 * This software is distributed under the terms of the FSF Lesser
 * Gnu Public License (see LGPL.txt).
 * 
 * Apache Jakarta Commons-Lang 2.1
 * 
 * This product contains software developed by the Apache Software Foundation
 * (http://www.apache.org/)
 * 
 * jopt-simpler
 * 
 * Copyright (c) 2004-2013 Paul R. Holser, Jr.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * Mozilla XULRunner 1.9.0.5
 * 
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/.
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 * 
 * The J2SE(TM) Java Runtime Environment
 * 
 * Copyright 2009 Sun Microsystems, Inc., 4150
 * Network Circle, Santa Clara, California 95054, U.S.A.  All
 * rights reserved. U.S.  
 * See the LICENSE file in the jre folder for more information.
 ******************************************************************************/

package edu.cmu.cs.hcii.cogtool.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.cmu.cs.hcii.cogtool.util.EnumeratedInt;
import edu.cmu.cs.hcii.cogtool.util.L10N;
import edu.cmu.cs.hcii.cogtool.util.ObjectLoader;
import edu.cmu.cs.hcii.cogtool.util.ObjectSaver;

/**
 *
 * This class is primarily for distinguishing between types of "TAP" commands
 * Tap, down, up, double tap, hover
 *
 * @author alexeiser
 *
 */
public class TapPressType extends EnumeratedInt
{
    public static final int edu_cmu_cs_hcii_cogtool_model_TapPressType_version = 0;

    private static ObjectSaver.IDataSaver<TapPressType> SAVER =
        new ObjectSaver.ADataSaver<TapPressType>() {
            @Override
            public int getVersion()
            {
                return edu_cmu_cs_hcii_cogtool_model_TapPressType_version;
            }

            @Override
            public boolean isEnum()
            {
                return true;
            }
        };

    public static void registerSaver()
    {
        ObjectSaver.registerSaver(TapPressType.class.getName(), SAVER);
    }

    private static ObjectLoader.IEnumLoader LOADER =
        new ObjectLoader.AEnumLoader() {
            @Override
            public Object createEnum(String persistentValue)
            {
                switch (Integer.parseInt(persistentValue)) {
                    case 0: return TapPressType.Tap;
                    case 1: return TapPressType.Down;
                    case 2: return TapPressType.Up;
                    case 3: return TapPressType.DoubleTap;
                    case 4: return TapPressType.Hover;
                    case 5: return TapPressType.TripleTap;
                }

                return null;
            }
        };

    public static void registerLoader()
    {
        ObjectLoader.registerEnumLoader(TapPressType.class.getName(),
                                        edu_cmu_cs_hcii_cogtool_model_TapPressType_version,
                                        LOADER);
    }

    // Various tap type definitions
    public static final TapPressType Tap =
        new TapPressType(L10N.get("TPT.Tap", "Tap"), 0);

    public static final TapPressType Down =
        new TapPressType(L10N.get("TPT.Down-Tap", "Down-Tap"), 1);

    public static final TapPressType Up =
        new TapPressType(L10N.get("TPT.Up-Tap", "Up-Tap"), 2);

    public static final TapPressType DoubleTap =
        new TapPressType(L10N.get("TPT.Double-Tap", "Double-Tap"), 3);

    public static final TapPressType Hover =
        new TapPressType(L10N.get("TPT.Hover", "Hover"), 4);

    public static final TapPressType TripleTap =
        new TapPressType(L10N.get("TPT.Triple-Tap", "Triple-Tap"), 5);

    /**
     * Display ordering
     */
    public static final TapPressType[] DISPLAY =
        { Tap, DoubleTap, TripleTap, Down, Up, Hover };

    // Constructor
    protected TapPressType(String lbl, int persistentValue)
    {
        super(lbl, persistentValue);
    }

    /**
     * The set of all values to support their iteration in a specific order.
     */
    protected static final TapPressType[] ITERATOR_ORDERING =
        { Tap, Down, Up, DoubleTap, TripleTap, Hover };

    public static final List<TapPressType> VALUES =
        Collections.unmodifiableList(Arrays.asList(ITERATOR_ORDERING));
}