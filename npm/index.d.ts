declare module '@apiverve/vatrates' {
  export interface vatratesOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface vatratesResponse {
    status: string;
    error: string | null;
    data: VATRatesData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface VATRatesData {
      country:       null | string;
      countryName:   null | string;
      currency:      null | string;
      effectiveFrom: Date | null;
      rates:         Rates;
      exception:     null;
  }
  
  interface Rates {
      standard:     number | null;
      reduced:      number | null;
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
