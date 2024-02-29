// Karma configuration
// Generated on Thu Feb 29 2024 21:20:07 GMT+0100 (heure normale d’Europe centrale)

module.exports = function(config) {
  config.set({

    basePath: '',
    frameworks: ['jasmine', '@angular-devkit/build-angular'],

    plugins: [
      require('karma-jasmine'),
      require('karma-coverage'),
      require('karma-chrome-launcher'),
      require('karma-jasmine-html-reporter'),
      require('karma-sonarqube-reporter'),
      require('@angular-devkit/build-angular/plugins/karma')
    ],

    client:{
      clearContext: false
    },

    coverageReporter: {
      dir: require('path').join(__dirname, './coverage'),
      reporters: [{ type: 'html', subdir: 'report-html' }, { type: 'text-summary' }, { type: 'lcovonly', subdir: '.' }]
    },

    reporters: ['progress', 'kjhtml', 'sonarqube'],

    port: 9876,

    coverageReporter: {
      type: 'lcovonly',
      dir: 'coverage/front',
      subdir: '.',
    },

    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    // start these browsers
    // available browser launchers: https://www.npmjs.com/search?q=keywords:karma-launcher
    browsers: ['Chrome'],


    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: false,

    sonarqubeReporter: {
      basePath: 'src/app', // test files folder
      filePattern: '**/*spec.ts', // test files glob pattern
      encoding: 'utf-8', // test files encoding
      outputFolder: 'reports', // report destination
      legacyMode: false, // report for Sonarqube < 6.2 (disabled)
      reportName: function (metadata) {
        // report name callback, but accepts also a
        // string (file name) to generate a single file
        /**
         * Report metadata array:
         * - metadata[0] = browser name
         * - metadata[1] = browser version
         * - metadata[2] = plataform name
         * - metadata[3] = plataform version
         */
        return 'sonarqube_report.xml';
      },
    },

    // Concurrency level
    // how many browser instances should be started simultaneously
    concurrency: Infinity
  })
}
