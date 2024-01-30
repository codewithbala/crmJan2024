export class Submission {
    id:                number;
    dateOfSubmission:  string;
    bdeName:           string;
    positionTitle:     string;
    candidateDetails:  CandidateDetails=new CandidateDetails;
    vendor:            Vendor = new Vendor;
    endClient:         EndClient = new EndClient;
    billRate:          number;
    billRateAnnual:    number;
    submissionStatus:  string;
    customerInterview: CustomerInterview = new CustomerInterview;
    projectStartDate:  Date;
    projectEndDate:    Date;
    remarks:           string;
}

export class CandidateDetails {
    candidateId: string;
}

export class CustomerInterview {
    interviewDate:     Date;
    interviewTime:     string;
    interviewResult:   string;
    interviewFeedback: Date;
}

export class EndClient {
    endClient: string;
    city:      string;
    state:     string;
}

export class Vendor {
    vendorTier: string;
    vendorName: string;
    spoc:       string;
    poc:        string;
    email:      string;
    phone:      string;
    state:      string;
    city:       string;
}

