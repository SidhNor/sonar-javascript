/*
 * Sonar JavaScript Plugin
 * Copyright (C) 2011 Eriks Nukis and SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.javascript.core;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.AbstractLanguage;
import org.sonar.plugins.javascript.JavaScriptPlugin;

public class JavaScript extends AbstractLanguage {

  public static final JavaScript INSTANCE = new JavaScript();
  
  /**
   * JavaScript key
   */
  public static final String KEY = "js";
  
  /**
   * JavaScript name
   */
  public static final String NAME = "JavaScript";

  private Settings settings;

  /**
   * Default constructor
   */
  public JavaScript() {
    super(KEY, NAME);
  }
  
  public JavaScript(Settings configuration) {
    super(KEY, NAME);
    this.settings = configuration;
  }

  public Settings getSettings() {
    return this.settings;
  }

  public String[] getFileSuffixes() {
    String[] suffixes = settings.getStringArray(JavaScriptPlugin.FILE_SUFFIXES_KEY);
    if (suffixes == null || suffixes.length == 0) {
      suffixes = StringUtils.split(JavaScriptPlugin.FILE_SUFFIXES_DEFVALUE, ",");
    }
    return suffixes;
  }

}
