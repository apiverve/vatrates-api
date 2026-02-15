using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.VATRates
{
    /// <summary>
    /// Query options for the VAT Rates API
    /// </summary>
    public class VATRatesQueryOptions
    {
        /// <summary>
        /// ISO 2-letter country code (e.g., DE, FR, ES)
        /// </summary>
        [JsonProperty("country")]
        public string Country { get; set; }

        /// <summary>
        /// Look up rate effective on this date (YYYY-MM-DD). Defaults to today.
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }

        /// <summary>
        /// Check for regional exceptions (e.g., Canary Islands, Ceuta)
        /// </summary>
        [JsonProperty("postcode")]
        public string Postcode { get; set; }
    }
}
