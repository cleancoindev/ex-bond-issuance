/**
 * Copyright (c) 2019, Digital Asset (Switzerland) GmbH and/or its affiliates. All rights reserved.
 * SPDX-License-Identifier: Apache-2.0
 */
package com.digitalasset.refapps.bondissuance.util;

import static com.digitalasset.refapps.bondissuance.util.PartyAllocator.ALL_PARTIES;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.StringArrayOptionHandler;

/** Command line options helper class. */
public class CliOptions {
  @Option(name = "-s", usage = "Sandbox host", metaVar = "SANDBOX_HOST")
  private final String sandboxHost = "localhost";

  @Option(name = "-p", usage = "Sandbox port", metaVar = "SANDBOX_PORT")
  private final int sandboxPort = 7600;

  @Option(
      name = "-u",
      usage = "Parties to run the application for.",
      handler = StringArrayOptionHandler.class,
      metaVar = "PARTIES")
  private final String[] parties = ALL_PARTIES;

  public String getSandboxHost() {
    return sandboxHost;
  }

  public int getSandboxPort() {
    return sandboxPort;
  }

  public String[] getParties() {
    return parties;
  }

  public static CliOptions parseArgs(String[] args) {
    CliOptions options = new CliOptions();
    CmdLineParser parser = new CmdLineParser(options);
    try {
      parser.parseArgument(args);
    } catch (CmdLineException e) {
      System.err.println("Invalid command line options");
      parser.printUsage(System.err);
      System.exit(1);
    }
    return options;
  }
}
