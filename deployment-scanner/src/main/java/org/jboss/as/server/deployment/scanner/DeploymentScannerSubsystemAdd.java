/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.server.deployment.scanner;

import java.util.Locale;
import org.jboss.as.controller.AbstractAddStepHandler;
import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.descriptions.DescriptionProvider;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.dmr.ModelNode;

/**
 * Handles the addition of the deployment scanning subsystem.
 *
 * @author Emanuel Muckenhuber
 */
public class DeploymentScannerSubsystemAdd extends AbstractAddStepHandler implements DescriptionProvider {

    static final String OPERATION_NAME = ModelDescriptionConstants.ADD;

    static final DeploymentScannerSubsystemAdd INSTANCE = new DeploymentScannerSubsystemAdd();

    private DeploymentScannerSubsystemAdd() {
        //
    }

    protected void populateModel(ModelNode operation, ModelNode model) {
        model.get(CommonAttributes.SCANNER).setEmptyObject();
    }

    protected boolean requiresRuntime(OperationContext context) {
        return false;
    }

    @Override
    public ModelNode getModelDescription(Locale locale) {
        return DeploymentSubsystemDescriptions.getSubsystemAdd(locale);
    }

}
