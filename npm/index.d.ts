declare module '@apiverve/vatrates' {
  export interface vatratesOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface vatratesResponse {
    status: string;
    error: string | null;
    data: VATRatesData;
    code?: number;
  }


  interface VATRatesData {
      country:       string;
      countryName:   string;
      currency:      string;
      effectiveFrom: Date;
      rates:         Rates;
      exception:     null;
  }
  
  interface Rates {
      standard:     number;
      reduced:      number;
      reduced2:     null;
      superReduced: null;
      parking:      null;
  }

  export default class vatratesWrapper {
    constructor(options: vatratesOptions);

    execute(callback: (error: any, data: vatratesResponse | null) => void): Promise<vatratesResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: vatratesResponse | null) => void): Promise<vatratesResponse>;
    execute(query?: Record<string, any>): Promise<vatratesResponse>;
  }
}
