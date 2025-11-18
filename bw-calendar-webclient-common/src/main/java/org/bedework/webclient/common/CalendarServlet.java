/* ********************************************************************
    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License. You may obtain a
    copy of the License at:

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on
    an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied. See the License for the
    specific language governing permissions and limitations
    under the License.
*/
package org.bedework.webclient.common;

import org.bedework.llc.common.ConfigCommon;
import org.bedework.util.jmx.ConfBase;
import org.bedework.util.servlet.MethodBase;
import org.bedework.util.servlet.ServletBase;
import org.bedework.webclient.config.ClientConf;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

/** This servlet handles the calendar servlet requests and responses.
 *
 * @author Mike Douglass   bedework.com
 * @version 1.0
 */
public abstract class CalendarServlet extends ServletBase {
  protected void initMethodBase(final MethodBase mb,
                                final ConfBase<?> conf,
                                final ServletContext context,
                                final boolean dumpContent,
                                final String methodName) throws ServletException {
    final var cfg = (ClientConf<?>)conf;
    cfg.loadConfig();
    final CalendarMethodBase cmb = (CalendarMethodBase)mb;

    try {
      cmb.init((ConfigCommon)cfg.getConfig(),
               context,
               dumpContent,
               methodName,
               appInfo);
    } catch (final Throwable t) {
      throw new ServletException(t);
    }
  }
}
