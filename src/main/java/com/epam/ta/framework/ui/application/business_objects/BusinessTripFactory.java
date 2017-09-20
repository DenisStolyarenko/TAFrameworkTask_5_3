package com.epam.ta.framework.ui.application.business_objects;

import com.epam.ta.framework.ui.application.commonconstants.AnyParameters;
import com.epam.ta.framework.ui.application.enums.ItemType;
import com.epam.ta.framework.ui.application.enums.Projects;
import com.epam.ta.framework.ui.application.enums.User;

public class BusinessTripFactory {
    public static BusinessTrip createSimpleBusinessTrip(){
        BusinessTrip businessTrip = new BusinessTrip();
        businessTrip.setSummary(ItemType.BT.getItemNameInSingular() + AnyParameters.summary);
        businessTrip.setActionPerfomer(User.T_USER);
        businessTrip.setProjectName(Projects.ENRC_TRD.getProjectName());
        businessTrip.setEstimatedBudget(AnyParameters.estimatedBudget);
        businessTrip.setPlannedStartDate(AnyParameters.plannedStartDate);
        businessTrip.setPlannedEndDate(AnyParameters.plannedEndDate);
        businessTrip.setLocationFrom(AnyParameters.locationFrom);
        businessTrip.setCountry(AnyParameters.country);
        businessTrip.setDestinationCity(AnyParameters.destinationCity);
        businessTrip.setDestinationAddress(AnyParameters.destinationAddress);
        businessTrip.setDescription(AnyParameters.description);

        return businessTrip;
    }

    public static BusinessTrip createBusinessTripForApprover(User user){
        BusinessTrip businessTrip = createSimpleBusinessTrip();
        businessTrip.setActionPerfomer(User.APPROVER);
        return businessTrip;
    }

    public static BusinessTrip createBusinessTripForApproveByDifferentLevel(Integer EstimatedBudget){
        BusinessTrip businessTrip = createSimpleBusinessTrip();
        businessTrip.setEstimatedBudget(EstimatedBudget);
        return businessTrip;
    }

}
