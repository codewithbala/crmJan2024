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
    projectStartDate:  string;
    projectEndDate:    string;
    remarks:           string;
}

export class CandidateDetails {
    candidateId: string;
}

export class CustomerInterview {
    interviewID?:number;
    cInterviewID:      number;
    interviewDate:     string;
    interviewTime:     string;
    interviewResult:   string;
    interviewFeedback: string;
}

export class EndClient {
    id?:number;
    endClientId: number;
    endClient: string;
    city:      string;
    state:     string;
}

export class Vendor {
    id?:number;
    vendorTier: string;
    vendorName: string;
    spoc:       string;
    poc:        string;
    email:      string;
    phone:      string;
    state:      string;
    city:       string;
    vendorId:    number;
}

