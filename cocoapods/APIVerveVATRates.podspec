Pod::Spec.new do |s|
  s.name             = 'APIVerveVATRates'
  s.version          = '1.2.3'
  s.summary          = 'VAT Rates is a European VAT rates API: send a two-letter country code and get the current VAT rates for that country as JSON, with the...'
  s.description      = <<-'DESC'
VAT Rates is a European VAT rates API: send a two-letter country code and get the current VAT rates for that country as JSON, with the full standard, reduced, super-reduced and parking set for EU members plus the UK, and standard rates for non-EU countries such as Switzerland and Norway. Paid plans add historical rates by date and regional exceptions by postcode.

This iOS/macOS SDK provides a convenient way to access the VAT Rates from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/vatrates?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/vatrates-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveVATRates/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
